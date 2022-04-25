SUMMARY = "Jami client with Qt backend"
LICENSE = "GPL-3.0-only"

LIC_FILES_CHKSUM = "file://COPYING;md5=1ebbd3e34237af26da5dc08a4e440464"

JAMI_QT_REV = "302f7000710f12f419798dc1cb7a17f10d781bd4"
JAMI_URI = "git://review.jami.net"
JAMI_PROT = "protocol=https;nobranch=1"

SRC_URI = " \
    ${JAMI_URI}/jami-client-qt;${JAMI_PROT};rev=${JAMI_QT_REV} \
    file://0001-mainapplication-fix-qFatal-syntax.patch \
"

S = "${WORKDIR}/git"
inherit qt6-cmake systemd

EXTRA_OECMAKE = "\
    -DLRC=${STAGING_DIR_TARGET}/usr \
"

DEPENDS += " \
    qtbase \
    qttools-native \
    qtdeclarative \
    qtsvg \
    qtwebengine \
    qtwebchannel \
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
    qtwebengine \
    qtwebengine-tools \
    qtwebchannel \
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
