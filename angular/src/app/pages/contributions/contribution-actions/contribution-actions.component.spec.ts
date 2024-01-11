import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContributionActionsComponent } from './contribution-actions.component';

describe('ContributionActionsComponent', () => {
  let component: ContributionActionsComponent;
  let fixture: ComponentFixture<ContributionActionsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ContributionActionsComponent]
    });
    fixture = TestBed.createComponent(ContributionActionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
