SUMMARY = "OpenDHT"
DESCRIPTION = "A lightweight C++14 Distributed Hash Table implementation."
LICENSE = "GPL-3.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "https://github.com/savoirfairelinux/${BPN}/archive/${PV}.tar.gz"
SRC_URI[sha256sum] = "917e5f691199349d6884a68c26645840914c18e72b2e21d97817618ddc55fb81"

S = "${WORKDIR}/${PN}-${PV}"

DEPENDS = " \
    fmt \
    asio \
    http-parser \
    restinio \
    libargon2 \
    openssl \
    gnutls \
    jsoncpp \
    msgpack-c \
    nettle \
"
RDEPENDS_${PN} = " \
    fmt \
    asio \
    zlib \
    http-parser \
    libargon2 \
    openssl \
    gnutls \
    jsoncpp \
    gnutls \
    msgpack-c \
    nettle \
"

EXTRA_OECMAKE = " \
    -DOPENDHT_TOOLS=OFF \
    -DOPENDHT_PROXY_SERVER=ON \
    -DOPENDHT_PROXY_CLIENT=ON \
"
inherit cmake
