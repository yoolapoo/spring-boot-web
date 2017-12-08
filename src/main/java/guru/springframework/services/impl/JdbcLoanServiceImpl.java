package guru.springframework.services.impl;


import guru.springframework.mapper.LoanMapper;
import guru.springframework.services.LoanService;

public class JdbcLoanServiceImpl implements LoanService {

    private LoanMapper loanMapper;

    public JdbcLoanServiceImpl(LoanMapper loanMapper){
        super();
        this.loanMapper = loanMapper;
    }

    @Override
    public void addLoan(long id_user, long id_media){ this.loanMapper.addLoan(id_user,id_media);}

    @Override
    public void deleteLoan(long id_user, long id_media){ this.loanMapper.addLoan(id_user,id_media);}

}
