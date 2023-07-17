SUMMARY = "Jami client with Qt backend"
LICENSE = "GPL-3.0-only"

LIC_FILES_CHKSUM = "file://COPYING;md5=1ebbd3e34237af26da5dc08a4e440464"

JAMI_QT_REV = "b948646cbd201b023b18c9d5cc3d6cca45bba00c"
JAMI_URI = "gitsm://review.jami.net"
JAMI_PROT = "protocol=https;nobranch=1"

SRC_URI = " \
    ${JAMI_URI}/jami-client-qt;${JAMI_PROT};rev=${JAMI_QT_REV} \
"

S = "${WORKDIR}/git"
inherit autotools-brokensep qt6-cmake systemd pkgconfig

EXTRA_OECMAKE = "\
    -DLRC=${STAGING_DIR_TARGET}/usr \
    -DWITH_WEBENGINE=false \
    -DWITH_X11=false \
    -DWITH_DAEMON_SUBMODULE=true \
    -DENABLE_LIBWRAP=true \
"

DEPENDS += " \
    cargo \
    doxygen-native \
    ffmpeg \
    jami-daemon \
    libarchive \
    libdbus-c++ \
    libdbus-c++-native \
    libgit2 \
    libnotify \
    libsecp256k1 \
    libupnp \
    networkmanager \
    opendht \
    pjproject \
    pulseaudio \
    qrencode \
    qt5compat \
    qtbase \
    qtdeclarative \
    qtmultimedia \
    qtnetworkauth \
    qtpositioning \
    qtsvg \
    qttools-native \
    sdbus-c++-tools-native \
    speex \
    speexdsp \
    webrtc-audio-processing \
    yaml-cpp \
    "

RDEPENDS:${PN} = " \
    bash \
    ca-certificates \
    ffmpeg \
    jami-daemon \
    libarchive \
    networkmanager \
    opendht \
    pulseaudio-server \
    qrencode \
    qt5compat \
    qtbase \
    qtdeclarative \
    qtmultimedia \
    qtnetworkauth \
    qtsvg \
    ttf-bitstream-vera \
    yaml-cpp \
    "

FILES:${PN} += " \
        /usr/share/* \
        "