package models;

public class Binding {
    private int BindingId;
    private String BindingName;

    public Binding(int bindingId, String bindingName) {
        this.BindingId = bindingId;
        this.BindingName = bindingName;
    }

    public Binding(String bindingName) {
        this.BindingName = bindingName;
    }

    public int getBindingId() {
        return BindingId;
    }

    public void setBindingId(int bindingId) {
        BindingId = bindingId;
    }

    public String getBindingName() {
        return BindingName;
    }

    public void setBindingName(String bindingName) {
        BindingName = bindingName;
    }
}
