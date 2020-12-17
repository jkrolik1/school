import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BestAllComponent } from './bestall.component';

describe('BestAllComponent', () => {
  let component: BestAllComponent;
  let fixture: ComponentFixture<BestAllComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BestAllComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BestAllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
