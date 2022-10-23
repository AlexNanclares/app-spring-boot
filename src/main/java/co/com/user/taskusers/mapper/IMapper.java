package co.com.user.taskusers.mapper;

public interface IMapper <Input, Input2, Output>{
    public Output map(Input in, Input2 dependence);
}
