SUMMARY = "C implementation of Argon2"
LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=3f577d9446ded914cd9f8f0ae099a45a"

SRC_URI = "https://github.com/P-H-C/phc-winner-argon2/archive/${PV}.tar.gz"
SRC_URI[sha256sum] = "daf972a89577f8772602bf2eb38b6a3dd3d922bf5724d45e7f9589b5e830442c"

S = "${WORKDIR}/phc-winner-argon2-${PV}"

do_compile() {
	oe_runmake LIBRARY_REL=/lib
}

do_install() {
	oe_runmake LIBRARY_REL=/lib PREFIX="${D}${prefix}" install
}
