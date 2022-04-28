SUMMARY = "Jami client with Qt backend"
LICENSE = "GPL-3.0-only"

LIC_FILES_CHKSUM = "file://COPYING;md5=1ebbd3e34237af26da5dc08a4e440464"

JAMI_QT_REV = "3f88ceda932f6e3a41be28dca63f7ba0e9e761ad"
JAMI_URI = "git://review.jami.net"
JAMI_PROT = "protocol=https;nobranch=1"

SRC_URI = " \
    ${JAMI_URI}/jami-client-qt;${JAMI_PROT};rev=${JAMI_QT_REV} \
    file://0001-remove-positioning.patch \
"

S = "${WORKDIR}/git"
inherit qt6-cmake systemd

EXTRA_OECMAKE = "\
    -DLRC=${STAGING_DIR_TARGET}/usr \
    -DWITH_WEBENGINE=false \
"

DEPENDS += " \
    qtbase \
    qttools-native \
    qtdeclarative \
    qtsvg \
    jami-libclient \
    networkmanager \
    qrencode \
    qt5compat \
    qtmultimedia \
    qtnetworkauth \
    "

RDEPENDS:${PN} = " \
    qtbase \
    qtdeclarative \
    qtsvg \
    networkmanager \
    qrencode \
    jami-daemon \
    jami-libclient \
    ttf-bitstream-vera \
    bash \
    qt5compat \
    qtmultimedia \
    qtnetworkauth \
    ca-certificates \
    "

FILES:${PN} += " \
        /usr/share/* \
        "
