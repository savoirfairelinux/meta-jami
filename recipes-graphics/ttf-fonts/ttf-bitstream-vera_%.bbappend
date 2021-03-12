do_install_append() {
        install -d ${D}${libdir_native}/fonts
        for i in *.ttf; do
                install -m 644 $i ${D}${libdir_native}/fonts
        done
}

FILES_${PN} += " ${libdir_native}/fonts"
