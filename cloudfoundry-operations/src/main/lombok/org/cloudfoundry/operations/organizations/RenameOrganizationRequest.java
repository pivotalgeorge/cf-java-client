/*
 * Copyright 2013-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cloudfoundry.operations.organizations;

import lombok.Builder;
import lombok.Data;
import org.cloudfoundry.Validatable;
import org.cloudfoundry.ValidationResult;

/**
 * The request options for the rename organization operation
 */
@Data
public final class RenameOrganizationRequest implements Validatable {

    /**
     * The name of the organization
     *
     * @param name the name of the organization
     * @return the name of the organization
     */
    private final String name;

    /**
     * The new name of the organization
     *
     * @param newName the new name of the organization
     * @return the new name of the organization
     */
    private final String newName;

    @Builder
    RenameOrganizationRequest(String name, String newName) {
        this.name = name;
        this.newName = newName;
    }

    @Override
    public ValidationResult isValid() {
        ValidationResult.ValidationResultBuilder builder = ValidationResult.builder();

        if (this.name == null) {
            builder.message("name must be specified");
        }

        if (this.newName == null) {
            builder.message("new name must be specified");
        }

        return builder.build();
    }

}
