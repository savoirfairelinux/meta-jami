SUMMARY = "DHTNet, a Lightweight Peer-to-Peer Communication Library"

LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=c078891f53322564c490150e256305e8"

SRC_URI = "git://github.com/savoirfairelinux/dhtnet.git;protocol=https;branch=master"
SRCREV = "6dd5a5e3eb15cebafa212e134ce436705c6d5fc5"

S = "${WORKDIR}/git"

DEPENDS = " \
    fmt \
    msgpack-c \
    opendht \
    pjproject \
    readline \
"

RDEPENDS:${PN} = " \
    fmt \
    msgpack-c \
    opendht \
    pjproject \
    readline \
"

inherit cmake pkgconfig

EXTRA_OECMAKE = " \
        -DBUILD_DEPENDENCIES=OFF \
        -DDHTNET_NATPMP=OFF \
        -DDHTNET_PUPNP=OFF \
        -DBUILD_TOOLS=OFF \
        -DBUILD_BENCHMARKS=OFF \
        -DBUILD_EXAMPLES=OFF \
        -DBUILD_SHARED_LIBS=ON \
"
