LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f5e274d60596dd59be0a1d1b19af7978 \
                    file://LICENSE-MIT;md5=f5e274d60596dd59be0a1d1b19af7978"

SRC_URI = "https://github.com/nodejs/llhttp/archive/refs/tags/release/v${PV}.tar.gz"
SRC_URI[sha256sum] = "1a2b45cb8dda7082b307d336607023aa65549d6f060da1d246b1313da22b685a"

S = "${WORKDIR}/llhttp-release-v${PV}"

inherit cmake
