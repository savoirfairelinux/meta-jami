SUMMARY = "Jami libclient"
LICENSE = "LGPL-2.1"

LIC_FILES_CHKSUM = "file://COPYING;md5=14247b9fda5b3eaef1568f099dac2e0a"

LIBCLIENT_REV = "a2f2991124715ae0e1c4463c941176b529e43f4b"
JAMI_URI = "git://review.jami.net"
JAMI_PROT = "protocol=https;nobranch=1"

SRC_URI = " \
    ${JAMI_URI}/jami-libclient;${JAMI_PROT};rev=${LIBCLIENT_REV} \
"

S = "${WORKDIR}/git"
inherit cmake_qt5

TARGET_CPPFLAGS += "-I${RECIPE_SYSROOT}${includedir}/jami"

EXTRA_OECMAKE = " \
    -DRING_XML_INTERFACES_DIR=${RECIPE_SYSROOT}${datadir}/dbus-1/interfaces/ \
"

DEPENDS += "qtbase qttools-native jami-daemon"

do_install_append() {
    rm -rf ${D}/usr/share
}
