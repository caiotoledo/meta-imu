SUMMARY = "Script for DBus Launch init"
SECTION = "Application"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

INITSCRIPT_NAME = "init-dbus"
INITSCRIPT_PARAMS = "defaults 99 10"

FILEEXTRAPATHS_prepend = "${THISDIR}/files"
SRC_URI = "file://init-dbus"

RDEPENDS_${PN} = "dbus"

do_install_append() {
	install -d ${D}/etc/init.d
	install -m 0755 ${WORKDIR}/init-dbus ${D}/etc/init.d/
}

inherit update-rc.d
