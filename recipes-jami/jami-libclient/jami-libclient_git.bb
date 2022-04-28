SUMMARY = "Jami libclient"
LICENSE = "LGPL-2.1-only"

LIC_FILES_CHKSUM = "file://COPYING;md5=14247b9fda5b3eaef1568f099dac2e0a"

LIBCLIENT_REV = "c5bca2933fb02ef7f81e8fe0772801a4f97fd1f5"
JAMI_URI = "git://review.jami.net"
JAMI_PROT = "protocol=https;nobranch=1"

SRC_URI = " \
    ${JAMI_URI}/jami-libclient;${JAMI_PROT};rev=${LIBCLIENT_REV} \
"

S = "${WORKDIR}/git"
inherit qt6-cmake

TARGET_CPPFLAGS += "-I${RECIPE_SYSROOT}${includedir}/jami"

EXTRA_OECMAKE = " \
    -DENABLE_LIBWRAP=true \
    -DRING_BUILD_DIR=${RECIPE_SYSROOT}${includedir} \
"

DEPENDS += "qtbase qttools-native jami-daemon"

do_install:append() {
    rm -rf ${D}/usr/share
}
