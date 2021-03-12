SUMMARY = "Jami daemon"
LICENSE = "GPL-3.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=c078891f53322564c490150e256305e8"

DRING_REV = "924cd61091de766f78390dab588b6413696db70a"
JAMI_URI = "git://review.jami.net"
JAMI_PROT = "protocol=https;nobranch=1"

SRC_URI = " \
    ${JAMI_URI}/ring-daemon;${JAMI_PROT};rev=${DRING_REV} \
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
    speex \
    speexdsp \
    libsecp256k1 \
    libupnp \
"

RDEPENDS-${PN} += " \
    opendht \
    ffmpeg \
    libarchive \
    pulseaudio-server \
    yaml-cpp \
"

# Workaround Workaround to avoid having to create a native dbus-c++ package.
do_configure_prepend() {
    ln -sf /usr/bin/dbusxx-xml2cpp ${RECIPE_SYSROOT_NATIVE}/usr/bin/dbusxx-xml2cpp
}

do_configure_append() {
    if [ ! -e libtool ] ; then
        ln -s ${HOST_PREFIX}libtool libtool
    fi
}

FILES_${PN} += " \
    ${datadir}/ring/ringtones/* \
    ${datadir}/dbus-1/services/cx.ring.Ring.service \
    ${libdir}/ring/dring \
    ${sysconfdir}/default/dring \
"
FILES_${PN}-dev += " \
    ${datadir}/dbus-1/interfaces/* \
"
