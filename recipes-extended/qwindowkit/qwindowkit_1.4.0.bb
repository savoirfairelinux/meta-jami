SUMMARY = "Cross-platform window customization framework for Qt Widgets and Qt Quick."

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b22c1e0849dc22c380016cdd8abd3a6"

SRC_URI = "git://github.com/stdware/qwindowkit.git;protocol=https;branch=main"
SRCREV = "5c04046acae6e61280fba7fef31401edd7c36087"

S = "${WORKDIR}/git"

inherit qt6-cmake

DEPENDS = " \
    qmsetup-native \
    qtbase \
    qtdeclarative \
    qtdeclarative-native \
"

RDEPENDS:${PN} = " \
    qtbase \
    qtdeclarative \
"

FILES:${PN} += "${datadir}/QWindowKit"
