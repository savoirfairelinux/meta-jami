SUMMARY = "Jami client with Qt backend"
LICENSE = "GPL-3.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=1ebbd3e34237af26da5dc08a4e440464"

JAMI_QT_REV = "32a8978ff1fba9175cd3db67b8fbde21ac320b72"

SRC_URI = " \
    git://review.jami.net/jami-client-qt;protocol=https;nobranch=1;rev=${JAMI_QT_REV} \
"

S = "${WORKDIR}/git"
inherit cmake_qt5 systemd

EXTRA_OECMAKE = "\
    -DLRC=${STAGING_DIR_TARGET}/usr \
"

DEPENDS += " \
    qtbase \
    qttools-native \
    qtquickcontrols \
    qtquickcontrols2 \
    qtdeclarative \
    qtsvg \
    qtwebengine \
    qtwebchannel \
    qtlocation \
    jami-lrc \
    networkmanager \
    qrencode \
    "

RDEPENDS_${PN} = " \
    qtbase \
    qtquickcontrols2 \
    qtquickcontrols \
    qtdeclarative \
    qtsvg \
    qtwebengine \
    qtwebchannel \
    qtlocation \
    networkmanager \
    qrencode \
    jami-daemon \
    jami-lrc \
    ttf-bitstream-vera \
    bash \
    qtgraphicaleffects-qmlplugins \
    "

FILES_${PN} += " \
        /usr/share/* \
        "
