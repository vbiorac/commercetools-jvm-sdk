package io.sphere.sdk.customergroups.commands;

import io.sphere.sdk.commands.DeleteCommand;
import io.sphere.sdk.customergroups.CustomerGroup;
import io.sphere.sdk.customergroups.expansion.CustomerGroupExpansionModel;
import io.sphere.sdk.expansion.MetaModelExpansionDsl;
import io.sphere.sdk.models.Versioned;

/**
 * Deletes a customer group.
 *
 * {@include.example io.sphere.sdk.customergroups.commands.CustomerGroupDeleteCommandTest#execution()}
 *
 * @see CustomerGroup
 */
public interface CustomerGroupDeleteCommand extends MetaModelExpansionDsl<CustomerGroup, CustomerGroupDeleteCommand, CustomerGroupExpansionModel<CustomerGroup>>, DeleteCommand<CustomerGroup> {
    static DeleteCommand<CustomerGroup> of(final Versioned<CustomerGroup> customerGroup) {
        return new CustomerGroupDeleteCommandImpl(customerGroup);
    }
}
