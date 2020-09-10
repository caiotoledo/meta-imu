FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

do_install_append() {
	install -m 600 ${WORKDIR}/dnsmasq.conf ${D}${sysconfdir}/dnsmasq.conf
}
