package org.library_project.api.config;

public enum WorkerRoleAuthority {
    INVENTORY_MANAGEMENT{
        @Override
        public String toString() {
            return "INVENTORY_MANAGEMENT";
        }
    },
    HR_MANAGEMENT{
        @Override
        public String toString() {
            return "HR_MANAGEMENT";
        }
    },
    READERS_MANAGEMENT{
        @Override
        public String toString() {
            return "READERS_MANAGEMENT";
        }
    },
    SYSTEM_MANAGEMENT{
        @Override
        public String toString() {
            return "SYSTEM_MANAGEMENT";
        }
    }
}
