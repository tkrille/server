/*
 * Copyright (C) 2013 tarent AG
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.osiam.storage.query;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import org.osiam.resources.exceptions.InvalidConstraintException;
import org.osiam.storage.entities.AddressEntity.CanonicalAddressTypes;
import org.osiam.storage.entities.EmailEntity.CanonicalEmailTypes;
import org.osiam.storage.entities.ExtensionFieldEntity;
import org.osiam.storage.entities.ImEntity.CanonicalImTypes;
import org.osiam.storage.entities.PhoneNumberEntity.CanonicalPhoneNumberTypes;
import org.osiam.storage.entities.PhotoEntity.CanonicalPhotoTypes;

public enum FilterConstraint {
    EQUALS("eq") {
        @Override
        public Predicate createPredicateForStringField(Path<String> path, String value, CriteriaBuilder cb) {
            return cb.equal(path, value);
        }

        @Override
        public Predicate createPredicateForDateField(Path<Date> path, Date value, CriteriaBuilder cb) {
            return cb.equal(path, value);
        }

        @Override
        public Predicate createPredicateForBooleanField(Path<Boolean> path, Boolean value, CriteriaBuilder cb) {
            return cb.equal(path, value);
        }

        @Override
        public Predicate createPredicateForEmailTypeField(Path<CanonicalEmailTypes> path, CanonicalEmailTypes value,
                CriteriaBuilder cb) {
            return cb.equal(path, value);
        }

        @Override
        public Predicate createPredicateForExtensionField(Path<String> path, String value, ExtensionFieldEntity field,
                CriteriaBuilder cb) {
            if (!field.isConstrainedValid(toString())) {
                throw new InvalidConstraintException(toString());
            }
            return createPredicateForStringField(path, value, cb);
        }

        @Override
        public Predicate createPredicateForAddressTypeField(Path<CanonicalAddressTypes> path,
                CanonicalAddressTypes value, CriteriaBuilder cb) {
            return cb.equal(path, value);
        }

        @Override
        public Predicate createPredicateForPhoneNumberTypeField(Path<CanonicalPhoneNumberTypes> path,
                CanonicalPhoneNumberTypes value, CriteriaBuilder cb) {
            return cb.equal(path, value);
        }

        @Override
        public Predicate createPredicateForImTypeField(Path<CanonicalImTypes> path, CanonicalImTypes value,
                CriteriaBuilder cb) {
            return cb.equal(path, value);
        }

        @Override
        public Predicate createPredicateForPhotoTypeField(Path<CanonicalPhotoTypes> path, CanonicalPhotoTypes value,
                CriteriaBuilder cb) {
            return cb.equal(path, value);
        }

    },
    CONTAINS("co") {
        @Override
        public Predicate createPredicateForStringField(Path<String> path, String value, CriteriaBuilder cb) {
            return cb.like(path, "%" + value + "%");
        }

        @Override
        public Predicate createPredicateForDateField(Path<Date> path, Date value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForBooleanField(Path<Boolean> path, Boolean value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForEmailTypeField(Path<CanonicalEmailTypes> path, CanonicalEmailTypes value,
                CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForExtensionField(Path<String> path, String value, ExtensionFieldEntity field,
                CriteriaBuilder cb) {
            if (!field.isConstrainedValid(toString())) {
                throw new InvalidConstraintException(toString());
            }
            return createPredicateForStringField(path, value, cb);
        }

        @Override
        public Predicate createPredicateForAddressTypeField(Path<CanonicalAddressTypes> path,
                CanonicalAddressTypes value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForPhoneNumberTypeField(Path<CanonicalPhoneNumberTypes> path,
                CanonicalPhoneNumberTypes value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForImTypeField(Path<CanonicalImTypes> path, CanonicalImTypes value,
                CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForPhotoTypeField(Path<CanonicalPhotoTypes> path, CanonicalPhotoTypes value,
                CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

    },
    STARTS_WITH("sw") {
        @Override
        public Predicate createPredicateForStringField(Path<String> path, String value, CriteriaBuilder cb) {
            return cb.like(path, value + "%");
        }

        @Override
        public Predicate createPredicateForDateField(Path<Date> path, Date value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForBooleanField(Path<Boolean> path, Boolean value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForEmailTypeField(Path<CanonicalEmailTypes> path, CanonicalEmailTypes value,
                CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForExtensionField(Path<String> path, String value, ExtensionFieldEntity field,
                CriteriaBuilder cb) {
            if (!field.isConstrainedValid(toString())) {
                throw new InvalidConstraintException(toString());
            }
            return createPredicateForStringField(path, value, cb);
        }

        @Override
        public Predicate createPredicateForAddressTypeField(Path<CanonicalAddressTypes> path,
                CanonicalAddressTypes value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForPhoneNumberTypeField(Path<CanonicalPhoneNumberTypes> path,
                CanonicalPhoneNumberTypes value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForImTypeField(Path<CanonicalImTypes> path, CanonicalImTypes value,
                CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForPhotoTypeField(Path<CanonicalPhotoTypes> path, CanonicalPhotoTypes value,
                CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }
    },
    PRESENT("pr") {
        @Override
        public Predicate createPredicateForStringField(Path<String> path, String value, CriteriaBuilder cb) {
            return cb.and(cb.isNotNull(path), cb.notEqual(path, ""));
        }

        @Override
        public Predicate createPredicateForDateField(Path<Date> path, Date value, CriteriaBuilder cb) {
            return cb.isNotNull(path);
        }

        @Override
        public Predicate createPredicateForBooleanField(Path<Boolean> path, Boolean value, CriteriaBuilder cb) {
            return cb.and();
        }

        @Override
        public Predicate createPredicateForEmailTypeField(Path<CanonicalEmailTypes> path, CanonicalEmailTypes value,
                CriteriaBuilder cb) {
            return cb.isNotNull(path);
        }

        @Override
        public Predicate createPredicateForExtensionField(Path<String> path, String value, ExtensionFieldEntity field,
                CriteriaBuilder cb) {
            if (!field.isConstrainedValid(toString())) {
                throw new InvalidConstraintException(toString());
            }
            return createPredicateForStringField(path, value, cb);
        }

        @Override
        public Predicate createPredicateForAddressTypeField(Path<CanonicalAddressTypes> path,
                CanonicalAddressTypes value, CriteriaBuilder cb) {
            return cb.isNotNull(path);
        }

        @Override
        public Predicate createPredicateForPhoneNumberTypeField(Path<CanonicalPhoneNumberTypes> path,
                CanonicalPhoneNumberTypes value, CriteriaBuilder cb) {
            return cb.isNotNull(path);
        }

        @Override
        public Predicate createPredicateForImTypeField(Path<CanonicalImTypes> path, CanonicalImTypes value,
                CriteriaBuilder cb) {
            return cb.isNotNull(path);
        }

        @Override
        public Predicate createPredicateForPhotoTypeField(Path<CanonicalPhotoTypes> path, CanonicalPhotoTypes value,
                CriteriaBuilder cb) {
            return cb.isNotNull(path);
        }
    },
    GREATER_THAN("gt") {
        @Override
        public Predicate createPredicateForStringField(Path<String> path, String value, CriteriaBuilder cb) {
            return cb.greaterThan(path, value);
        }

        @Override
        public Predicate createPredicateForDateField(Path<Date> path, Date value, CriteriaBuilder cb) {
            return cb.greaterThan(path, value);
        }

        @Override
        public Predicate createPredicateForBooleanField(Path<Boolean> path, Boolean value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForEmailTypeField(Path<CanonicalEmailTypes> path, CanonicalEmailTypes value,
                CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForExtensionField(Path<String> path, String value, ExtensionFieldEntity field,
                CriteriaBuilder cb) {
            if (!field.isConstrainedValid(toString())) {
                throw new InvalidConstraintException(toString());
            }
            return createPredicateForStringField(path, value, cb);
        }

        @Override
        public Predicate createPredicateForAddressTypeField(Path<CanonicalAddressTypes> path,
                CanonicalAddressTypes value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForPhoneNumberTypeField(Path<CanonicalPhoneNumberTypes> path,
                CanonicalPhoneNumberTypes value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForImTypeField(Path<CanonicalImTypes> path, CanonicalImTypes value,
                CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForPhotoTypeField(Path<CanonicalPhotoTypes> path, CanonicalPhotoTypes value,
                CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }
    },
    GREATER_EQUALS("ge") {
        @Override
        public Predicate createPredicateForStringField(Path<String> path, String value, CriteriaBuilder cb) {
            return cb.greaterThanOrEqualTo(path, value);
        }

        @Override
        public Predicate createPredicateForDateField(Path<Date> path, Date value, CriteriaBuilder cb) {
            return cb.greaterThanOrEqualTo(path, value);
        }

        @Override
        public Predicate createPredicateForBooleanField(Path<Boolean> path, Boolean value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForEmailTypeField(Path<CanonicalEmailTypes> path, CanonicalEmailTypes value,
                CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForExtensionField(Path<String> path, String value, ExtensionFieldEntity field,
                CriteriaBuilder cb) {
            if (!field.isConstrainedValid(toString())) {
                throw new InvalidConstraintException(toString());
            }
            return createPredicateForStringField(path, value, cb);
        }

        @Override
        public Predicate createPredicateForAddressTypeField(Path<CanonicalAddressTypes> path,
                CanonicalAddressTypes value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForPhoneNumberTypeField(Path<CanonicalPhoneNumberTypes> path,
                CanonicalPhoneNumberTypes value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForImTypeField(Path<CanonicalImTypes> path, CanonicalImTypes value,
                CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForPhotoTypeField(Path<CanonicalPhotoTypes> path, CanonicalPhotoTypes value,
                CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

    },
    LESS_THAN("lt") {
        @Override
        public Predicate createPredicateForStringField(Path<String> path, String value, CriteriaBuilder cb) {
            return cb.lessThan(path, value);
        }

        @Override
        public Predicate createPredicateForDateField(Path<Date> path, Date value, CriteriaBuilder cb) {
            return cb.lessThan(path, value);
        }

        @Override
        public Predicate createPredicateForBooleanField(Path<Boolean> path, Boolean value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForEmailTypeField(Path<CanonicalEmailTypes> path, CanonicalEmailTypes value,
                CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForExtensionField(Path<String> path, String value, ExtensionFieldEntity field,
                CriteriaBuilder cb) {
            if (!field.isConstrainedValid(toString())) {
                throw new InvalidConstraintException(toString());
            }
            return createPredicateForStringField(path, value, cb);
        }

        @Override
        public Predicate createPredicateForAddressTypeField(Path<CanonicalAddressTypes> path,
                CanonicalAddressTypes value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForPhoneNumberTypeField(Path<CanonicalPhoneNumberTypes> path,
                CanonicalPhoneNumberTypes value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForImTypeField(Path<CanonicalImTypes> path, CanonicalImTypes value,
                CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForPhotoTypeField(Path<CanonicalPhotoTypes> path, CanonicalPhotoTypes value,
                CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }
    },
    LESS_EQUALS("le") {
        @Override
        public Predicate createPredicateForStringField(Path<String> path, String value, CriteriaBuilder cb) {
            return cb.lessThanOrEqualTo(path, value);
        }

        @Override
        public Predicate createPredicateForDateField(Path<Date> path, Date value, CriteriaBuilder cb) {
            return cb.lessThanOrEqualTo(path, value);
        }

        @Override
        public Predicate createPredicateForBooleanField(Path<Boolean> path, Boolean value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForEmailTypeField(Path<CanonicalEmailTypes> path, CanonicalEmailTypes value,
                CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForExtensionField(Path<String> path, String value, ExtensionFieldEntity field,
                CriteriaBuilder cb) {
            if (!field.isConstrainedValid(toString())) {
                throw new InvalidConstraintException(toString());
            }
            return createPredicateForStringField(path, value, cb);
        }

        @Override
        public Predicate createPredicateForAddressTypeField(Path<CanonicalAddressTypes> path,
                CanonicalAddressTypes value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForPhoneNumberTypeField(Path<CanonicalPhoneNumberTypes> path,
                CanonicalPhoneNumberTypes value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForImTypeField(Path<CanonicalImTypes> path, CanonicalImTypes value,
                CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public Predicate createPredicateForPhotoTypeField(Path<CanonicalPhotoTypes> path, CanonicalPhotoTypes value,
                CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }
    };

    static Map<String, FilterConstraint> stringToEnum = new ConcurrentHashMap<>();

    static {
        for (final FilterConstraint constraint : values()) {
            stringToEnum.put(constraint.toString(), constraint);
        }
    }

    public static FilterConstraint fromString(String name) {
        return stringToEnum.get(name.toLowerCase());
    }

    @Override
    public String toString() {
        return name;
    }

    private final String name; // NOSONAR - is not singular because it is used in the static block

    FilterConstraint(String constraint) {
        this.name = constraint;
    }

    public abstract Predicate createPredicateForStringField(Path<String> path, String value, CriteriaBuilder cb);

    public abstract Predicate createPredicateForDateField(Path<Date> path, Date value, CriteriaBuilder cb);

    public abstract Predicate createPredicateForBooleanField(Path<Boolean> path, Boolean value, CriteriaBuilder cb);

    public abstract Predicate createPredicateForEmailTypeField(Path<CanonicalEmailTypes> path,
            CanonicalEmailTypes value, CriteriaBuilder cb);

    public abstract Predicate createPredicateForAddressTypeField(Path<CanonicalAddressTypes> path,
            CanonicalAddressTypes value, CriteriaBuilder cb);

    public abstract Predicate createPredicateForExtensionField(Path<String> path, String value,
            ExtensionFieldEntity field, CriteriaBuilder cb);

    public abstract Predicate createPredicateForPhoneNumberTypeField(Path<CanonicalPhoneNumberTypes> path,
            CanonicalPhoneNumberTypes value, CriteriaBuilder cb);

    public abstract Predicate createPredicateForImTypeField(Path<CanonicalImTypes> path, CanonicalImTypes value,
            CriteriaBuilder cb);

    public abstract Predicate createPredicateForPhotoTypeField(Path<CanonicalPhotoTypes> path,
            CanonicalPhotoTypes value, CriteriaBuilder cb);
}