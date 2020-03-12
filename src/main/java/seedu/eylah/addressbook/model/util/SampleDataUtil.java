package seedu.eylah.addressbook.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.eylah.addressbook.model.AddressBook;
import seedu.eylah.addressbook.model.ReadOnlyAddressBook;

import seedu.eylah.addressbook.model.person.Name;
import seedu.eylah.addressbook.model.person.Person;
import seedu.eylah.diettracker.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {

    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), getTagSet("friends")),
            new Person(new Name("Bernice Yu"), getTagSet("colleagues", "friends")),
            new Person(new Name("Charlotte Oliveiro"), getTagSet("neighbours")),
            new Person(new Name("David Li"), getTagSet("family")),
            new Person(new Name("Irfan Ibrahim"), getTagSet("classmates")),
            new Person(new Name("Roy Balakrishnan"), getTagSet("colleagues"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
