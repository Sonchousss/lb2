public enum Country
{
    RUSSIA("Россия"),
    BELARUS ("Беларусь"),
    KAZAKHSTAN("Казахстан"),
    UZBEKISTAN("Узбекистан");

    private String title;

    Country(String title) {
        this.title = title;
    }

    public String getTitle() {return title;}

    @Override
    public String toString() {return title;}
}
