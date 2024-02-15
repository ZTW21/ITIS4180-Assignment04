package edu.uncc.assignment04;

import androidx.appcompat.app.AppCompatActivity;

import edu.uncc.assignment04.fragments.DemographicFragment;
import edu.uncc.assignment04.fragments.IdentificationFragment;
import edu.uncc.assignment04.fragments.MainFragment;
import edu.uncc.assignment04.fragments.ProfileFragment;
import edu.uncc.assignment04.fragments.SelectEducationFragment;
import edu.uncc.assignment04.fragments.SelectIncomeFragment;
import edu.uncc.assignment04.fragments.SelectLivingStatusFragment;
import edu.uncc.assignment04.fragments.SelectMaritalStatusFragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentListener, IdentificationFragment.IdentificationFragmentListener, DemographicFragment.DemographicFragmentListener, SelectEducationFragment.SelectEducationFragmentListener, SelectMaritalStatusFragment.SelectMaritalStatusFragmentListener, SelectLivingStatusFragment.SelectLivingStatusFragmentListener, SelectIncomeFragment.SelectIncomeFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.rootView, new MainFragment())
                .commit();
    }

    @Override
    public void goToIdentification() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new IdentificationFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToDemographic(Response response) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, DemographicFragment.newInstance(response), "DemographicFragment")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToEducation() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new SelectEducationFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToMaritalStatus() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new SelectMaritalStatusFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToLivingStatus() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new SelectLivingStatusFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToIncome() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new SelectIncomeFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToProfile(Response response) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, ProfileFragment.newInstance(response))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void sendEducation(String education) {
        DemographicFragment fragment = (DemographicFragment) getSupportFragmentManager().findFragmentByTag("DemographicFragment");
        if (fragment != null) {
            fragment.setSelectedEducation(education);
        }
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void cancelEducation() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void cancelMaritalStatus() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void sendMaritalStatus(String maritalStatus) {
        DemographicFragment fragment = (DemographicFragment) getSupportFragmentManager().findFragmentByTag("DemographicFragment");
        if (fragment != null) {
            fragment.setSelectedMaritalStatus(maritalStatus);
        }
        getSupportFragmentManager().popBackStack();

    }

    @Override
    public void cancelLivingStatus() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void sendLivingStatus(String livingStatus) {
        DemographicFragment fragment = (DemographicFragment) getSupportFragmentManager().findFragmentByTag("DemographicFragment");
        if (fragment != null) {
            fragment.setSelectedLivingStatus(livingStatus);
        }
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void cancelIncome() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void sendIncome(String income) {
        DemographicFragment fragment = (DemographicFragment) getSupportFragmentManager().findFragmentByTag("DemographicFragment");
        if (fragment != null) {
            fragment.setSelectedIncome(income);
        }
        getSupportFragmentManager().popBackStack();
    }
}