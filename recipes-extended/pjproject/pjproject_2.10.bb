# Based on https://github.com/geoffrey-vl/pjsip-yocto/blob/master/pjproject_2.6.bb
# Copyright (c) 2018 Geoffrey Van Landeghem
# Copyright (c) 2021 Savoir-faire Linux

DESCRIPTION = "Open source SIP stack and media stack for presence, im/instant \
               messaging, and multimedia communication"
SECTION = "libs"
HOMEPAGE = "http://www.pjsip.org/"

LICENSE = "GPL-2.0-or-later"

LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = "gnutls"

S = "${WORKDIR}/git"

inherit autotools-brokensep pkgconfig pythonnative

PARALLEL_MAKE="-j 1"

SRC_URI = " \
    git://github.com/pjsip/pjproject.git;protocol=https;branch=master \
    file://0001-rfc6544.patch \
    file://0002-rfc2466.patch \
    file://0003-add-tcp-keep-alive.patch \
    file://0004-multiple_listeners.patch \
    file://0005-fix_ebusy_turn.patch \
    file://0006-ignore_ipv6_on_transport_check.patch \
    file://0007-upnp-srflx-nat-assisted-cand.patch \
    file://0008-fix_ioqueue_ipv6_sendto.patch \
    file://0009-add-config-site.patch \
    file://0010-fix-pkgconfig.patch \
    file://0011-fix-tcp-death-detection.patch \
    file://0012-fix-turn-shutdown-crash.patch \
    file://0013-Assign-unique-local-preferences-for-candidates-with-.patch \
    file://0014-Add-new-compile-time-setting-PJ_ICE_ST_USE_TURN_PERM.patch \
    file://0015-update-local-preference-for-peer-reflexive-candidate.patch \
    file://0016-use-addrinfo-instead-CFHOST.patch \
    file://0017-Makefile-replace-cp-with-install.patch \
"

SRCREV = "3e7b75cb2e482baee58c1991bd2fa4fb06774e0d"

SRC_URI[sha256sum] = "936a4c5b98601b52325463a397ddf11ab4106c6a7b04f8dc7cdd377efbb597de"

EXTRA_OECONF = " \
    --disable-sound        \
    --enable-video         \
    --enable-ext-sound     \
    --disable-speex-aec    \
    --disable-g711-codec   \
    --disable-l16-codec    \
    --disable-gsm-codec    \
    --disable-g722-codec   \
    --disable-g7221-codec  \
    --disable-speex-codec  \
    --disable-ilbc-codec   \
    --disable-opencore-amr \
    --disable-silk         \
    --disable-sdl          \
    --disable-ffmpeg       \
    --disable-v4l2         \
    --disable-openh264     \
    --disable-resample     \
    --disable-libwebrtc    \
    --enable-epoll         \
    --enable-shared        \
    --disable-static       \
    --with-gnutls          \
"

EXTRA_OEMAKE = "EXCLUDE_APP=1"

do_configure:prepend () {
    export LD="${CC}"
    # Force compiling with position independent code and compile in release mode
    # without asserts
    echo "export CFLAGS += -fPIC -DNDEBUG" > user.mak
    echo "export LDFLAGS += -fuse-ld=bfd" >> user.mak
    rm -f aconfigure
    autoconf -o configure aconfigure.ac
}

do_install:append() {
    # Do not install static libraries
    rm -vf ${D}${libdir}/*.a

    # remove the absolute path to the host's include dir
    sed -i 's:\-I/usr/include::' ${D}/usr/lib/pkgconfig/libpjproject.pc
    # remove the fdebug-prefix-map options
    sed -i 's:\-fdebug-prefix-map[a-zA-Z0-9\._\/=\-]*::g' ${D}/usr/lib/pkgconfig/libpjproject.pc
}

INSANE_SKIP:${PN} = "ldflags"
