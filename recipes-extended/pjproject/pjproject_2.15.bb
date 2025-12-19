# Based on https://github.com/geoffrey-vl/pjsip-yocto/blob/master/pjproject_2.6.bb
# Copyright (c) 2018 Geoffrey Van Landeghem
# Copyright (c) 2021 Savoir-faire Linux

DESCRIPTION = "Open source SIP stack and media stack for presence, im/instant \
               messaging, and multimedia communication"
SECTION = "libs"
HOMEPAGE = "http://www.pjsip.org/"

LICENSE = "GPL-2.0-or-later"

PJPROJECT_REV = "93dc96918bb6ba74e1e1d00c40c80402e856f2ac"
PJPROJECT_URI = "git://review.jami.net/pjproject"
PJPROJECT_PROT = "protocol=https;branch=sfl-2.15"

LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = " \
					${PJPROJECT_URI};${PJPROJECT_PROT};rev=${PJPROJECT_REV} \
					file://0001-win-config.patch \
					file://0002-win-vs-gnutls.patch \
					"

DEPENDS = "gnutls"

S = "${WORKDIR}/git"

inherit autotools-brokensep pkgconfig python3native

PARALLEL_MAKE="-j 1"


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

do_configure:prepend() {
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
    # force ownership of the files to root
    chown -R root:root ${D}${libdir}
}

INSANE_SKIP:${PN} = "ldflags"
