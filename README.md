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
branch: 2.0
revision: 907416ee1062f87f5844ab0638b54616abfc1a22
prio: default

URI: git://github.com/openembedded/openembedded-core.git
branch: kirkstone
revision: f20a12ead2d5890e88e7f4ce149a777de47edc48
prio: default

URI: git://github.com/openembedded/meta-openembedded.git
branch: kirkstone
revision: 346753705e49a2486867dc150181a1c7f4d69377
layers: meta-oe, meta-networking, meta-multimedia
prio: default

URI: git://code.qt.io/yocto/meta-qt6.git
branch: 6.4
revision: 24f23ee49a2c32be9d1b799a4616003c2ac53a21
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
