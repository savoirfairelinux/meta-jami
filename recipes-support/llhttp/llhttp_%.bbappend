# Needed because restinio cannot find the shared library version
EXTRA_OECMAKE += "-DBUILD_SHARED_LIBS=OFF -DBUILD_STATIC_LIBS=ON"
