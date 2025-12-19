SUMMARY = "Jami daemon"
LICENSE = "GPL-3.0-only"

LIC_FILES_CHKSUM = "file://COPYING;md5=614d5aba617892f88a0f696f6d411149"

JAMID_REV = "d79fb875075d6130fd247806f70b08e4619d30f8"
JAMI_URI = "git://review.jami.net"
JAMI_PROT = "protocol=https;nobranch=1"

SRC_URI = " \
        ${JAMI_URI}/jami-daemon;${JAMI_PROT};rev=${JAMID_REV} \
        file://0001-Makefile.am-disable-man-pages-generation.patch \
"

S = "${WORKDIR}/git"

inherit autotools-brokensep pkgconfig systemd

EXTRA_OECMAKE = " \
				-DJAMI_DBUS=false \
				"

DEPENDS += " \
    asio \
    dhtnet \
    ffmpeg \
    fmt \
    gnutls \
    jack \
    libarchive \
    libdbus-c++ \
    libdbus-c++-native \
    libgit2 \
    libsecp256k1 \
    libupnp \
    liburcu \
    lttng-ust \
    minizip \
    nettle \
    opencv \
    opendht \
    openssh \
    openssl \
    pjproject \
    pulseaudio \
    restinio \
    sdbus-c++ \
    sdbus-c++-tools-native \
    speex \
    speexdsp \
    webrtc-audio-processing \
    x264 \
    yaml-cpp \
    zlib \
"

RDEPENDS:${PN} += " \
    dhtnet \
    ffmpeg \
    libarchive \
    opendht \
    pulseaudio-server \
    yaml-cpp \
"

do_configure:append() {
    if [ ! -e libtool ] ; then
        ln -s ${HOST_PREFIX}libtool libtool
    fi
}

FILES:${PN} += " \
    ${datadir}/jami/ringtones/* \
    ${datadir}/dbus-1/services/cx.ring.Ring.service \
"
FILES:${PN}-dev += " \
    ${datadir}/dbus-1/interfaces/* \
"
