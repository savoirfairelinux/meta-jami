SUMMARY = "http-parser"
DESCRIPTION = "This is a parser for HTTP messages written in C. It parses both requests and responses. The parser is designed to be used in performance HTTP applications. It does not make any syscalls nor allocations, it does not buffer data, it can be interrupted at anytime. Depending on your architecture, it only requires about 40 bytes of data per message stream (in a web server that is per connection)."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE-MIT;md5=9bfa835d048c194ab30487af8d7b3778"

SRC_URI = "https://github.com/nodejs/http-parser/archive/v${PV}.tar.gz"
SRC_URI[sha256sum] = "467b9e30fd0979ee301065e70f637d525c28193449e1b13fbcb1b1fab3ad224f"

S = "${WORKDIR}/${PN}-${PV}"

do_compile() {
	oe_runmake library
}

do_install() {
	oe_runmake INCLUDEDIR="${D}${includedir}" LIBDIR="${D}/${libdir}" install
}
