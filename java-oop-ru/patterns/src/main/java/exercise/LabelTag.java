package exercise;

// BEGIN
class LabelTag implements TagInterface {

    private String text;
    private TagInterface child;

    LabelTag(String text, TagInterface child) {
        this.text = text;
        this.child = child;
    }

    public String render() {
        return "<label>" + text + child.render() + "</label>";
    }
}
// END
