SUMMARY = "Jami libclient"
LICENSE = "LGPL-2.1-only"

LIC_FILES_CHKSUM = "file://COPYING;md5=14247b9fda5b3eaef1568f099dac2e0a"

LIBCLIENT_REV = "b0409a8ec4a8c8a78cf4035b996c5e7e5e1983c3"
JAMI_URI = "git://review.jami.net"
JAMI_PROT = "protocol=https;nobranch=1"

SRC_URI = " \
    ${JAMI_URI}/jami-libclient;${JAMI_PROT};rev=${LIBCLIENT_REV} \
"

S = "${WORKDIR}/git"
inherit qt6-cmake

TARGET_CPPFLAGS += "-I${RECIPE_SYSROOT}${includedir}/jami"

EXTRA_OECMAKE = " \
    -DRING_XML_INTERFACES_DIR=${RECIPE_SYSROOT}${datadir}/dbus-1/interfaces/ \
"

DEPENDS += "qtbase qttools-native jami-daemon"

do_install:append() {
    rm -rf ${D}/usr/share
}
