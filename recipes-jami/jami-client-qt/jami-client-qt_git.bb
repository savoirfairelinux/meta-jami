SUMMARY = "Jami client with Qt backend"
LICENSE = "GPL-3.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=1ebbd3e34237af26da5dc08a4e440464"

JAMI_QT_REV = "ae21c17da5e8f730ae3895ccbc4da8047e3be1eb"

SRC_URI = " \
    git://review.jami.net/jami-client-qt;protocol=https;nobranch=1;rev=${JAMI_QT_REV} \
    file://0001-previewrenderer-disconnect-signals-on-destroy.patch \
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
