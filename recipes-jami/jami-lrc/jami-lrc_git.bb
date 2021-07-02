SUMMARY = "Jami libclient"
LICENSE = "LGPL-2.1"

LIC_FILES_CHKSUM = "file://COPYING;md5=14247b9fda5b3eaef1568f099dac2e0a"

LRC_REV = "cf359be9d0dbc5e73a0b31e2f519acdaa2f6aec0"
JAMI_URI = "git://review.jami.net"
JAMI_PROT = "protocol=https;nobranch=1"

SRC_URI = " \
    ${JAMI_URI}/ring-lrc;${JAMI_PROT};rev=${LRC_REV} \
"

S = "${WORKDIR}/git"
inherit cmake_qt5

TARGET_CPPFLAGS += "-I${RECIPE_SYSROOT}${includedir}/dring"

EXTRA_OECMAKE = " \
    -DRING_XML_INTERFACES_DIR=${RECIPE_SYSROOT}${datadir}/dbus-1/interfaces/ \
"

DEPENDS += "qtbase qttools-native jami-daemon"

do_install_append() {
    rm -rf ${D}/usr/share
}
