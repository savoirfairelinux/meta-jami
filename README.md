Jami OpenEmbedded/Yocto layer
=============================

This layer provides support for the open source communication platform Jami.
Jami is a free and open source audio, video and text peer-to-peer communication
platform. It does not require a server, and implements distributed and secure
end-to-end encrypted communications for multiple platforms.
Website: https://jami.net/

To enable Jami, add jami-client-qt to your IMAGE_INSTALL.

        IMAGE_INSTALL += "jami-client-qt"

Dependencies
------------
This layer depends on:

URI: git@github.com:openembedded/bitbake.git
branch: 2.8
tag: yocto-5.0.14
revision: 8dcf084522b9c66a6639b5f117f554fde9b6b45a
prio: default

URI: git://github.com/openembedded/openembedded-core.git
branch: scarthgap
tag: yocto-5.0.14
revision: 471adaa5f77fa3b974eab60a2ded48e360042828
prio: default

URI: git://github.com/openembedded/meta-openembedded.git
branch: scarthgap
revision: 7ed4330bcf1ecd4aa34bfbe1fd7079381b62b1e7
layers: meta-oe, meta-networking, meta-multimedia
prio: default

URI: git://code.qt.io/yocto/meta-qt6.git
branch: 6.5
revision: 9c6fe907d6287cac3c3f2895a7d4d87bf4d269b5
prio: default

Yocto version support
---------------------
meta-jami is tested with the following Yocto branches:
- kirkstone

Community / Colaboration
------------------------

Repository: https://github.com/savoirfairelinux/meta-jami

Maintenance
-----------

Send pull requests, patches, comments or questions on GitHub.

License
-------

All metadata is GPL-3.0 licensed unless otherwise stated. Source code included
in tree for individual recipes is under the LICENSE stated in each recipe
(.bb file) unless otherwise stated.
