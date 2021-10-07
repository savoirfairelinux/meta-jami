SUMMARY = "Jami daemon"
LICENSE = "GPL-3.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=c078891f53322564c490150e256305e8"

JAMID_REV = "e3240d578142da19ae92f03ec09fb889c8b5fe77"
JAMI_URI = "git://review.jami.net"
JAMI_PROT = "protocol=https;nobranch=1"

SRC_URI = " \
    ${JAMI_URI}/jami-daemon;${JAMI_PROT};rev=${JAMID_REV} \
    file://0001-Makefile.am-disable-man-pages-generation.patch \
"
S = "${WORKDIR}/git"

inherit autotools-brokensep pkgconfig systemd

DEPENDS += " \
    opendht \
    ffmpeg \
    libarchive \
    pjproject \
    yaml-cpp \
    pulseaudio \
    libdbus-c++ \
    libdbus-c++-native \
    speex \
    speexdsp \
    libsecp256k1 \
    libupnp \
    libgit2 \
    webrtc-audio-processing \
"

RDEPENDS-${PN} += " \
    opendht \
    ffmpeg \
    libarchive \
    pulseaudio-server \
    yaml-cpp \
"

do_configure_append() {
    if [ ! -e libtool ] ; then
        ln -s ${HOST_PREFIX}libtool libtool
    fi
}

FILES_${PN} += " \
    ${datadir}/jami/ringtones/* \
    ${datadir}/dbus-1/services/cx.ring.Ring.service \
"
FILES_${PN}-dev += " \
    ${datadir}/dbus-1/interfaces/* \
"
