package org.david.crudusers.repositories.country;

import org.david.crudusers.models.Continent;
import org.david.crudusers.models.Country;
import org.david.crudusers.repositories.IRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * DAO de country
 */
public interface ICountryRepository extends IRepository<Country> {

    Optional<Country> byName(String name)  throws SQLException;

    List<Country> byContinent(Continent continent)  throws SQLException;

    Optional<Country> byAcronym(String acronym)  throws SQLException;

    List<Country> byLanguage(String language)  throws SQLException;
}
