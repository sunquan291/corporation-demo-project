package com.zte.sunquan.demo.compile;

/**
 * Created by 10184538 on 2017/7/20.
 */
public class JavaFile {

    private String name;
    private String fullName;
    private String pkg="";

    private String path;

    public JavaFile(String path) {
        this.path = path;
    }

    public JavaFile(String name, String pkg, String path) {
        this.name = name;
        this.pkg = pkg;
        this.fullName = this.pkg + "." + this.name;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return this.fullName = this.pkg + "." + this.name;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPkg() {
        return pkg;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JavaFile javaFile = (JavaFile) o;

        if (!name.equals(javaFile.name)) return false;
        if (!fullName.equals(javaFile.fullName)) return false;
        if (!pkg.equals(javaFile.pkg)) return false;
        return path.equals(javaFile.path);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + fullName.hashCode();
        result = 31 * result + pkg.hashCode();
        result = 31 * result + path.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("JavaFile{");
        sb.append("name='").append(name).append('\'');
        sb.append(", fullName='").append(getFullName()).append('\'');
        sb.append(", pkg='").append(pkg).append('\'');
        sb.append(", path='").append(path).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
