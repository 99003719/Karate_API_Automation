package Tests.users;

import com.intuit.karate.junit5.Karate;

class TestRunner {
    
    @Karate.Test
    Karate testUsers() {
        return Karate.run("Add_item_existing_id",
                "Add_item_non_existing_id",
                "Add_item_with_missing_info",
                "Filter_by_id",
                "Get_all_menu_items",
                "Validate_recent_added_item_is_present_in_the_inventory"
                ).relativeTo(getClass());
    }

}
