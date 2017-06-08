package cn.sunfit.risk.buz.api.constants;

public enum ContractFields {

    SECOND_PART_FIELD_NAME("name", "合作方名称");

    private String key;

    private String name;

    ContractFields(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setName(String name) {
        this.name = name;
    }

}
