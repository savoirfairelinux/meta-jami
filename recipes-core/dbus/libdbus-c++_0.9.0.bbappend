FILESEXTRAPATHS:prepend := "${THISDIR}/libdbus-c++_0.9.0:"
SRC_URI += "file://dispatcher.h"

do_install:append() {
    install -m 0644 ${WORKDIR}/dispatcher.h ${D}/${includedir}/dbus-c++-1/dbus-c++/
}
