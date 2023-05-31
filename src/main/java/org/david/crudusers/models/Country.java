package org.david.crudusers.models;

public class Country {

    private Long id;

    private String name;

    private Continent continent;

    private String acronym;

    private String language;

    public Country() {
    }

    public Country(Long id, String name, Continent continent, String acronym, String language) {
        this.id = id;
        this.name = name;
        this.continent = continent;
        this.acronym = acronym;
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", continent=" + continent +
                ", acronym='" + acronym + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
