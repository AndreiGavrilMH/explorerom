package explore.romania.explorerom.domain;

public enum Region {
    Dobrogea("Dobrogea"), Muntenia("Muntenia"), Oltenia("Oltenia"),
    Banat("Banat"), Transilvania("Transilvania"), Moldova("Moldova"),
    Bucovina("Bucovina"), Maramures("Maramures");

    private String label;

    private Region(String label) {
        this.label = label;
    }

    public static Region findByLabel(String byLabel) {
        for (Region r : Region.values()) {
            if (r.label.equalsIgnoreCase(byLabel))
                return r;
        }
        return null;
    }

}
