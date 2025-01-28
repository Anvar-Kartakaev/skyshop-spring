package org.skypro.skyshop.model.search;

import java.util.UUID;

public interface Searchable {

    default String getStringRepresentation() {
        return "Объект " + getContentType() + " типа " + getNameTerm();
    }

    default int getId() {
        return UUID.randomUUID().hashCode();
    }

    String getSearchTerm();

    String getContentType();

    String getNameTerm();

}
