SUMMARY = "Jami client with Qt backend"
LICENSE = "GPL-3.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=1ebbd3e34237af26da5dc08a4e440464"

JAMI_QT_REV = "b3788e0082bae4e4921862db059701c92dd63fe3"
JAMI_URI = "git://review.jami.net"
JAMI_PROT = "protocol=https;nobranch=1"

SRC_URI = " \
    ${JAMI_URI}/jami-client-qt;${JAMI_PROT};rev=${JAMI_QT_REV} \
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
    jami-libclient \
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
    jami-libclient \
    ttf-bitstream-vera \
    bash \
    qtgraphicaleffects-qmlplugins \
    "

FILES_${PN} += " \
        /usr/share/* \
        "
