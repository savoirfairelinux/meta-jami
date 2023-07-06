SUMMARY = "Jami daemon"
LICENSE = "GPL-3.0-only"

LIC_FILES_CHKSUM = "file://COPYING;md5=c078891f53322564c490150e256305e8"

JAMID_REV = "e8b1209b3dad18eb6a3dba2cec4db78303b54fdc"
JAMI_URI = "git://review.jami.net"
JAMI_PROT = "protocol=https;nobranch=1"

SRC_URI = " \
    ${JAMI_URI}/jami-daemon;${JAMI_PROT};rev=${JAMID_REV} \
"
S = "${WORKDIR}/git"

inherit autotools-brokensep pkgconfig systemd

DEPENDS += " \
    ffmpeg \
    libarchive \
    libdbus-c++ \
    libdbus-c++-native \
    libgit2 \
    libsecp256k1 \
    libupnp \
    opendht \
    pjproject \
    pulseaudio \
    speex \
    speexdsp \
    webrtc-audio-processing \
    yaml-cpp \
"

RDEPENDS:${PN} += " \
    ffmpeg \
    libarchive \
    opendht \
    pulseaudio-server \
    yaml-cpp \
"

LD_FLAGS += " -Wl,-Bsymbolic"

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
