do_install:append() {
        install -d ${D}${libdir_native}/fonts
        for i in *.ttf; do
                install -m 644 $i ${D}${libdir_native}/fonts
        done
}

FILES:${PN} += " ${libdir_native}/fonts"
