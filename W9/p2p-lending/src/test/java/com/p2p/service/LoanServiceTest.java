package com.p2p.service;

import com.p2p.domain.Borrower;
import com.p2p.domain.Loan;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoanServiceTest {
    private static final Logger logger = LogManager.getLogger(LoanServiceTest.class);
    @Test
    void shouldRejectLoanWhenBorrowerNotVerified() {
        // =====================================================
        // SCENARIO:
        // Borrower tidak terverifikasi (KYC = false)
        // Ketika borrower mengajukan pinjaman
        // Maka sistem harus menolak dengan melempar exception
        // =====================================================
        // =========================
        // Arrange (Initial Condition)
        logger.info("TC-01 Dimulai (shouldRejectLoanWhenBorrowerNotVerified");
        // =========================
        // Borrower belum lolos proses KYC
        Borrower borrower = new Borrower(false, 700);
        logger.info("Borrower Verified : False");
        logger.info("Credit Score {}: ",borrower.getCreditScore());
        // Service untuk pengajuan loan
        LoanService loanService = new LoanService();

        // Jumlah pinjaman valid
        BigDecimal amount = BigDecimal.valueOf(1000);
        logger.info("Amount : {}",amount);
        // =========================
        // Act (Action)
        // =========================
        
        // =========================
        // Assert (Expected Result)
        // =========================
        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount);
        });

        logger.info("TC-01 Selesai, berhasil melempar exception");
    }

    @Test
    void shouldRejectLoanWhenAmountIsZeroOrNegative(){
        
        // Skenario:
        // - Borrower valid
        // - Amount ≤ 0
        // Expected:
        // - Exception
        logger.info("TC-02 Mulai, shouldRejectLoanWhenAmountIsZeroOrNegative");
        // Borrower lolos proses KYC
        Borrower borrower = new Borrower(true, 800);
        logger.info("Borrower Verified : true");
        logger.info("Credit Score : {}",borrower.getCreditScore());
        // Service untuk pengajuan loan
        LoanService loanService = new LoanService();

        // Jumlah pinjaman tidak valid
        BigDecimal amount = BigDecimal.valueOf(0);
        logger.info("Amount : {}",amount);

        // Jika gagal maka melempar exception
        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount);
        });

        logger.info("TC-02 Selesai, berhasil melempar exception");
    }

    @Test
    void shouldApproveLoanWhenCreditScoreHigh(){
        // Skenario : Borrower verified, creditscore >= threshold
        // Expected :  Status = APPROVED

        logger.info("TC-03 Mulai, shouldApproveLoanWhenCreditScoreHigh");
        // Borrower verified
        Borrower borrower = new Borrower(true, 750);
        logger.info("Borrower Verified : true");
        logger.info("Credit Score : {}",borrower.getCreditScore());

        // Service
        LoanService loanService = new LoanService();

        // Jumlah pinjaman
        BigDecimal amount = BigDecimal.valueOf(1000);
        logger.info("Amount : {}",amount);
        // Borrower mengajukan loan
        Loan loan = loanService.createLoan(borrower, amount);

        logger.info("STATUS : {}",loan.getStatus());
        // Assert, berhasil jika APPROVED
        assertEquals(Loan.Status.APPROVED, loan.getStatus() );
        logger.info("TC-03 Selesai");
    }

    @Test
    void shouldRejectLoanWhenCreditScoreLow(){
        // Skenario : Borrower Verified, CreditScore < threshold
        // Expected : Status REJECTED

        logger.info("TC-04 Mulai, shouldRejectLoanWhenCreditScoreLow");
        // Borrower verified
        Borrower borrower = new Borrower(true, 550);
        logger.info("Borrower Verified :  true");
        logger.info("Credit Score : {}",borrower.getCreditScore());

        // Service
        LoanService loanService = new LoanService();

        // Jumlah pinjaman
        BigDecimal amount = BigDecimal.valueOf(1000);
        logger.info("Amount : {}",amount);

        // Borrower Mengajukan loan
        Loan loan = loanService.createLoan(borrower, amount);
        logger.info("STATUS : {}",loan.getStatus());

        // Assert, berhasil jika REJECTED
        assertEquals(Loan.Status.REJECTED, loan.getStatus());
        logger.info("TC-04 Selesai");
    }

    
}
