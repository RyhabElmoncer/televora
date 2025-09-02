package com.org.televora.BoxInternet.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BoxType {
    FIBRE("Box internet fibre", "/images/types/fibre.png", "Box internet fibre"),
    BOX_TV("Box internet avec TV", "/images/types/tv.png", "Box + TV"),
    BOX_MOBILE("Box internet avec Mobile", "/images/types/mobile.png", "Box + Mobile"),
    SANS_ENGAGEMENT("Box internet sans engagement", "/images/types/no_engagement.png", "Sans engagement"),
    PROMO("Box internet en promo", "/images/types/promo.png", "Box en promo"),
    PAS_CHER("Box internet pas cher", "/images/types/pas_cher.png", "Box pas cher"),
    ADSL_VDSL("Box internet ADSL et VDSL", "/images/types/adsl_vdsl.png", "Box ADSL et VDSL"),
    APPELS_ILIMITES("Box internet avec appels illimités", "/images/types/appels.png", "Appels illimités"),
    BOX_4G_5G("Box internet 4G et 5G", "/images/types/4g_5g.png", "Box 4G et 5G"),
    SEUL("Box internet seul (sans TV)", "/images/types/seul.png", "Internet seul (sans TV)"),
    SATELLITE("Box internet satellite", "/images/types/satellite.png", "Internet Satellite"),
    EXCLUSIF_WEB("Exclusif Web", "/images/types/exclusif_web.png", "Les Forfaits Exclusif Web"),
    VENTE_FLASH("Vente Flash", "/images/types/vente_flash.png", "Les Forfaits Box Vente Flash"),
    AVANTAGE_FREEBOX("Avantage Freebox + Mobile", "/images/types/freebox_mobile.png", ""),
    SERIE_SPECIALE("Série Spéciale", "/images/types/serie_speciale.png", ""),
    SERIE_LIMITEE("Série Limitée", "/images/types/serie_limitee.png", "");

    private final String label;
    private final String image;
    private final String description;
}
