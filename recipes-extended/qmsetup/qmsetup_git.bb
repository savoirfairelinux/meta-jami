SUMMARY = "CMake Modules and Basic Libraries for C/C++ projects like QWindowKit."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=30f2c59f25abbc119b1c31913b5096a3 \
                    file://src/syscmdline/LICENSE;md5=5ba298a89fdc283d758b13f689ea3675"

SRC_URI = "gitsm://github.com/stdware/qmsetup.git;protocol=https;branch=main"
SRC_URI:append:class-native = " file://0001-src-CMakeLists.txt-add-ARCH_INDEPENDENT.patch"
SRCREV = "8ef1fc9caca59b66d77d71cd3308094a975bee40"

S = "${WORKDIR}/git"

inherit cmake

BBCLASSEXTEND = "native"
