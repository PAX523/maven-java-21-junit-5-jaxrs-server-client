package org.example.jaxrsservice.model;

public class Data
{
    private String name;

    private int age;

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(final int age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return String.format("[Name: %s, Age: %d]", name, age);
    }
}
