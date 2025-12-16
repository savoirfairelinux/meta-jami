SUMMARY = "OpenDHT"
DESCRIPTION = "Unicode routines (UTF8, UTF16, UTF32) and Base64: billions of characters per second \
using SSE2, AVX2, NEON, AVX-512, RISC-V Vector Extension, LoongArch64, POWER."
LICENSE = "Apache-2.0 | MIT"

LIC_FILES_CHKSUM = "file://LICENSE-MIT;md5=44b8879887e312bc332a205805fb41d1 \
                    file://LICENSE-APACHE;md5=9a830e3d94d23c95cf7280a8e5d04741"

SRC_URI = "git://github.com/simdutf/simdutf.git;branch=master;protocol=https"
SRCREV = "02b1f47511616abc787cbbf5315b8af6155db127"

S = "${WORKDIR}/git"

inherit cmake
